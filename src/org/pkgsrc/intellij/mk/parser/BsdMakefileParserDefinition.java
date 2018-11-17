package org.pkgsrc.intellij.mk.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.PkgsrcLanguages;
import org.pkgsrc.intellij.mk.psi.BsdMakefileFile;
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes;

public class BsdMakefileParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(BsdMakefileTypes.T_COMMENT_LINE);

    public static final IFileElementType FILE = new IFileElementType(PkgsrcLanguages.MAKEFILE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return BsdMakefileLexerFactory.newLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new BsdMakefileParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return BsdMakefileTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new BsdMakefileFile(viewProvider);
    }
}
