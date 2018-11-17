package org.pkgsrc.intellij.mk.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import org.pkgsrc.intellij.mk.psi.BsdMakefileTypes;

%%

%class BsdMakefileLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

COMMENT_START = "#"
COMMENT = [^\n]+
NEWLINE = [\n]
OTHER = [^#\n]+

%state COMMENT

%%

<YYINITIAL> {COMMENT_START} {
    yybegin(COMMENT);
    return BsdMakefileTypes.COMMENT_START;
}

<COMMENT> {COMMENT} {
    return BsdMakefileTypes.COMMENT;
}

<YYINITIAL> {OTHER} {
    return BsdMakefileTypes.OTHER;
}

{NEWLINE} {
    yybegin(YYINITIAL);
    return BsdMakefileTypes.NEWLINE;
}
