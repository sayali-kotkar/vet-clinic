package serenitylabs.tutorials.vetclinic.domain;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.StringContains.containsString;

public class WhenWeCreateANewDog {

    @Test
    public void a_new_dog_should_have_a_name_and_a_breed_and_a_colour() throws Exception {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        assertThat(fido.getColour(), arrayContaining("Black"));
    }

    @Test
    public void a_new_dog_should_provide_info_in_correct_format(){
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        assertThat(fido.toString(), startsWith(fido.getName()));
        assertThat(fido.toString(), endsWith(fido.getBreed()));
        assertThat(fido.toString(), containsString("Black"));
    }

    @Test
    public void a_dog_can_have_several_colours() {
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black","Green","White");

        assertThat(fido.getColour(),arrayContaining("Black","Green","White"));

    }

}
