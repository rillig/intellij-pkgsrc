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
NEWLINE = [\n]
OTHER = [^#\n]+

%state WAITING_VALUE

%%

{COMMENT_START} {
    return BsdMakefileTypes.COMMENT_START;
}

{OTHER} {
    return BsdMakefileTypes.REST;
}

{NEWLINE} {
    return BsdMakefileTypes.NEWLINE;
}
