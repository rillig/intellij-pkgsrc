package org.pkgsrc.intellij.mk.parser;

import com.intellij.lexer.FlexAdapter;

public class BsdMakefileLexerAdapter extends FlexAdapter {
    public BsdMakefileLexerAdapter() {
        super(new BsdMakefileLexer(null));
    }
}
