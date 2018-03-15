package com.glb.bootcamp.bdd.pages;

import com.glb.bootcamp.pageobject.PageObjectBase;
import com.glb.bootcamp.waits.Waits;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.glb.bootcamp.waits.Waits.isVisible;

/**
 * HomeFBPage.
 */
public class HomeFBPage extends PageObjectBase {

    @FindBy(css = "a._2s25._606w")
    private WebElement profileNameSpan;

    public boolean hasProfileName() {
        return isVisible(profileNameSpan).isEnabled();
    }
}
