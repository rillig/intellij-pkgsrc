package org.pkgsrc.intellij.patch;

import com.intellij.lang.Language;

public class PatchLanguage extends Language {
    public PatchLanguage() {
        super("Pkgsrc patch file");
    }
}
