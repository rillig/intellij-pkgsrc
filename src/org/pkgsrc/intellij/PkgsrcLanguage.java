package org.pkgsrc.intellij;

import com.intellij.lang.Language;

public class PkgsrcLanguage extends Language {
    public static final Language INSTANCE = new PkgsrcLanguage();

    private PkgsrcLanguage() {
        super("pkgsrc");
    }
}
