/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2016 Hiroshi Miura
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package tokyo.northside.omegat.markdown;

import org.pegdown.ast.AbbreviationNode;
import org.pegdown.ast.AnchorLinkNode;
import org.pegdown.ast.AutoLinkNode;
import org.pegdown.ast.BlockQuoteNode;
import org.pegdown.ast.BulletListNode;
import org.pegdown.ast.CodeNode;
import org.pegdown.ast.DefinitionListNode;
import org.pegdown.ast.DefinitionNode;
import org.pegdown.ast.DefinitionTermNode;
import org.pegdown.ast.ExpImageNode;
import org.pegdown.ast.ExpLinkNode;
import org.pegdown.ast.HeaderNode;
import org.pegdown.ast.HtmlBlockNode;
import org.pegdown.ast.InlineHtmlNode;
import org.pegdown.ast.ListItemNode;
import org.pegdown.ast.MailLinkNode;
import org.pegdown.ast.Node;
import org.pegdown.ast.OrderedListNode;
import org.pegdown.ast.ParaNode;
import org.pegdown.ast.QuotedNode;
import org.pegdown.ast.RefImageNode;
import org.pegdown.ast.RefLinkNode;
import org.pegdown.ast.ReferenceNode;
import org.pegdown.ast.RootNode;
import org.pegdown.ast.SimpleNode;
import org.pegdown.ast.SpecialTextNode;
import org.pegdown.ast.StrikeNode;
import org.pegdown.ast.StrongEmphSuperNode;
import org.pegdown.ast.SuperNode;
import org.pegdown.ast.TableBodyNode;
import org.pegdown.ast.TableCaptionNode;
import org.pegdown.ast.TableCellNode;
import org.pegdown.ast.TableColumnNode;
import org.pegdown.ast.TableHeaderNode;
import org.pegdown.ast.TableNode;
import org.pegdown.ast.TableRowNode;
import org.pegdown.ast.TextNode;
import org.pegdown.ast.VerbatimNode;
import org.pegdown.ast.Visitor;
import org.pegdown.ast.WikiLinkNode;


/**
 * Markdown parser and serializer abstract class.
 * @author Hiroshi Miura
 */
abstract class AbstractMarkdownSerializer implements Visitor {

    AbstractMarkdownSerializer() {
    }

    /**
     * Accept nodes which should visit children.
     *
     * @param node super node.
     */
    public void visit(final RootNode node) {
        visitChildren(node);
    }

    public void visit(final BlockQuoteNode node) {
        visitChildren(node);
    }

    public void visit(final BulletListNode node) {
        visitChildren(node);
    }

    public void visit(final ExpLinkNode node) {
        visitChildren(node);
    }

    public void visit(final HeaderNode node) {
        visitChildren(node);
    }

    public void visit(final ListItemNode node) {
        visitChildren(node);
    }

    public void visit(final OrderedListNode node) {
        visitChildren(node);
    }

    public void visit(final ParaNode node) {
        visitChildren(node);
    }

    public void visit(final QuotedNode node) {
        visitChildren(node);
    }

    public void visit(final RefLinkNode node) {
        visitChildren(node);
    }

    public void visit(final StrongEmphSuperNode node) {
        visitChildren(node);
    }

    public void visit(final StrikeNode node) {
        visitChildren(node);
    }

    public void visit(final SuperNode node) {
        visitChildren(node);
    }

    public void visit(final TableBodyNode node) {
        visitChildren(node);
    }

    public void visit(final TableCaptionNode node) {
        visitChildren(node);
    }

    public void visit(final TableCellNode node) {
        visitChildren(node);
    }

    public void visit(final TableColumnNode node) {
        visitChildren(node);
    }

    public void visit(final TableHeaderNode node) {
        visitChildren(node);
    }

    public void visit(final TableNode node) {
        visitChildren(node);
    }

    public void visit(final TableRowNode node) {
        visitChildren(node);
    }

    // helper
    protected void visitChildren(final SuperNode node) {
        for (Node child : node.getChildren()) {
            child.accept(this);
        }
    }

    /**
     * Accept nodes.
     *
     * @param node some node.
     */
    public void visit(final Node node) {
    }

    public void visit(final AbbreviationNode node) {
    }

    public void visit(final AnchorLinkNode node) {
    }

    public void visit(final AutoLinkNode node) {
    }

    public void visit(final CodeNode node) {
    }

    public void visit(final DefinitionListNode node) {
    }

    public void visit(final DefinitionNode node) {
    }

    public void visit(final DefinitionTermNode node) {
    }

    public void visit(final ExpImageNode node) {
    }

    public void visit(final HtmlBlockNode node) {
    }

    public void visit(final InlineHtmlNode node) {
    }

    public void visit(final MailLinkNode node) {
    }

    public void visit(final ReferenceNode node) {
    }

    public void visit(final RefImageNode node) {
    }

    public void visit(final SimpleNode node) {
    }

    public void visit(final SpecialTextNode node) {
    }

    public void visit(final TextNode node) {
    }

    public void visit(final WikiLinkNode node) {
    }

    public void visit(final VerbatimNode node) {
    }
}
