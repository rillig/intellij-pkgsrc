package org.pkgsrc.intellij;

import com.intellij.lang.Language;
import org.pkgsrc.intellij.descr.DescrLanguage;
import org.pkgsrc.intellij.distinfo.DistinfoLanguage;
import org.pkgsrc.intellij.mk.BsdMakefileLanguage;
import org.pkgsrc.intellij.patch.PatchLanguage;
import org.pkgsrc.intellij.plist.PlistLanguage;

public interface PkgsrcLanguages {
    Language MAKEFILE = new BsdMakefileLanguage();
    Language PLIST = new PlistLanguage();
    Language DISTINFO = new DistinfoLanguage();
    Language PATCH = new PatchLanguage();
    Language DESCR = new DescrLanguage();
}

