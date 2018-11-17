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
HSPACE = [ \t]*

VARUSE_BRACE_START = "${"
VARUSE_BRACE_END = "}"
VARUSE_PAREN_START = "$("
VARUSE_PAREN_END = ")"

DIRECTIVE = "." {HSPACE} \w+

%state COMMENT

%%

<YYINITIAL> {COMMENT_START} {
    yybegin(COMMENT);
    return BsdMakefileTypes.COMMENT_START;
}

<COMMENT> {COMMENT} {
    return BsdMakefileTypes.COMMENT;
}

<YYINITIAL> {DIRECTIVE} {
    return BsdMakefileTypes.DIRECTIVE;
}

<YYINITIAL> {OTHER} {
    return BsdMakefileTypes.OTHER;
}

{NEWLINE} {
    yybegin(YYINITIAL);
    return BsdMakefileTypes.NEWLINE;
}
