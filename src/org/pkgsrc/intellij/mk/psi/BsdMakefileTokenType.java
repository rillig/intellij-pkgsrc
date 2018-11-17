package org.pkgsrc.intellij.mk.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.PkgsrcLanguages;

public class BsdMakefileTokenType extends IElementType {
    public BsdMakefileTokenType(@NotNull String debugName) {
        super(debugName, PkgsrcLanguages.MAKEFILE);
    }

    @Override
    public String toString() {
        return "BsdMakefileTokenType." + super.toString();
    }
}
