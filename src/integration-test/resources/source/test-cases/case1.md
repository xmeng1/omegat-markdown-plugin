# Setup With Amazon S3

**Note**: Since Seafile Server 5.0.0, all config files are moved to the central **conf** folder. [Read More](../deploy/new_directory_layout_5_0_0.md).

## Prepare

To setup Seafile Professional Server with Amazon S3:

- Setup the basic Seafile Professional Server following the guide on [Download and setup Seafile Professional Server](download_and_setup_seafile_professional_server.md)
- Install the python `boto` library. It's needed to access S3 service.
- Install and configure memcached. For best performance, Seafile requires install memcached and enable memcache for objects. We recommend to allocate 128MB memory for memcached. Edit /etc/memcached.conf

```
# Start with a cap of 64 megs of memory. It's reasonable, and the daemon default
# Note that the daemon will grow to this size, but does not start out holding this much
# memory
# -m 64
-m 128
```

It's recommended to create separate buckets for commit, fs, and block objects.
The key_id and key are required to authenticate you to S3. You can find the key_id and key in the "security credentials" section on your AWS account page.


### Use S3 in newer regions

After Januaray 2014, new regions of AWS will only support authentication signature version 4 for S3. At this time, new region includes Frankfurt and China.

To use S3 backend in these regions, add following options to commit_object_backend, fs_object_backend and block_backend section in seafile.conf

```
use_v4_signature = true
# eu-central-1 for Frankfurt region
aws_region = eu-central-1
```

For file search and webdav to work with the v4 signature mechanism, you need to add following lines to ~/.boto

```
[s3]
use-sigv4 = True
```

### Using memcached cluster

In a cluster environment, you may want to use a memcached cluster. In the above configuration, you have to specify all the memcached server node addresses in seafile.conf

```
memcached_options = --SERVER=192.168.1.134 --SERVER=192.168.1.135 --SERVER=192.168.1.136 --POOL-MIN=10 --POOL-MAX=100
```

Because the server package is built on CentOS 6, if you're using Debian/Ubuntu, you have to copy the system CA bundle to CentOS's CA bundle path. Otherwise Seafile can't find the CA bundle so that the SSL connection will fail.

```
sudo mkdir -p /etc/pki/tls/certs
sudo cp /etc/ssl/certs/ca-certificates.crt /etc/pki/tls/certs/ca-bundle.crt
sudo ln -s /etc/pki/tls/certs/ca-bundle.crt /etc/pki/tls/cert.pem
```

Another important note is that you **must not use '.' in your bucket names**. Otherwise the wildcard certificate for AWS S3 cannot be resolved. This is a limitation on AWS.



`host` is the address and port of the S3-compatible service. You cannot prepend "http" or "https" to the `host` option. By default it'll use http connections. If you want to use https connection, please set `use_https = true` option.

`path_style_request` asks Seafile to use URLs like `https://192.168.1.123:8080/bucketname/object` to access objects. In Amazon S3, the default URL format is in virtual host style, such as `https://bucketname.s3.amazonaws.com/object`. But this style relies on advanced DNS server setup. So most S3-compatible storage systems only implement the path style format.

