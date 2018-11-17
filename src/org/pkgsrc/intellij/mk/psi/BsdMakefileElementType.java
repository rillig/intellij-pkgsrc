package org.pkgsrc.intellij.mk.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.pkgsrc.intellij.PkgsrcLanguages;

public class BsdMakefileElementType extends IElementType {
    public BsdMakefileElementType(@NotNull @NonNls String debugName) {
        super(debugName, PkgsrcLanguages.MAKEFILE);
    }
}
