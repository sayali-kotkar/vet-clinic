package serenitylabs.tutorials.vetclinic.collections.katas;

import com.google.common.collect.Lists;
import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WhenBookingPetsIntoAPetHotel {

    @Test
    public void the_hotel_should_initially_have_no_pets_booked() {
        PetHotel petHotel = new PetHotel();

        assertThat(petHotel.getPets().values(), empty());
    }

    @Test
    public void should_be_able_to_check_a_pet_into_the_hotel() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet bruno = Pet.cat().named("Bruno");
        petHotel.checkIn(bruno);

        assertThat(petHotel.getPets().values(), contains(bruno));
    }

    @Test
    public void should_be_able_to_check_in_several_pets() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet bruno = Pet.cat().named("Bruno");
        Pet uno = Pet.cat().named("Uno");
        Pet funny = Pet.cat().named("Funny");

        petHotel.checkIn(bruno);
        petHotel.checkIn(uno);
        petHotel.checkIn(funny);
        assertThat(petHotel.getPets().values(), containsInAnyOrder(bruno,uno,funny));
    }


    @Test
    public void should_not_be_able_to_check_in_the_same_pet_twice() throws Exception {

        PetHotel petHotel = new PetHotel();
        Pet fido = Pet.dog().named("Fido");
        Pet bruno = Pet.dog().named("Bruno");

        petHotel.checkIn(fido);
        petHotel.checkIn(bruno);
        petHotel.checkIn(fido);

        assertThat(petHotel.getPets().values(), containsInAnyOrder(fido, bruno));
    }


    @Test
    public void should_be_able_to_retrieve_checked_in_pets_in_alphabetical_order() throws Exception {
        //no java 8
    }

    @Test
    public void should_be_able_to_obtain_a_booking_confirmation_when_we_check_in_a_pet() throws Exception {
        PetHotel petHotel = new PetHotel();
        Pet bruno = Pet.cat().named("Bruno");
        BookingResponse bookingResponse = petHotel.checkIn(bruno);

        assertThat("Booking is not confirmed", bookingResponse.isConfirmed());
        assertThat(bookingResponse.getBookingNumber(), any(Integer.class));
    }

    @Test
    public void should_not_be_able_to_check_in_pets_beyond_hotel_capacity() throws Exception {

        PetHotel petHotel = new PetHotel();
        checkInSomePets(petHotel,PetHotel.MAX_HOTEL_CAPACITY );

        assertThat(petHotel.getPets().values(),hasSize(PetHotel.MAX_HOTEL_CAPACITY));

    }

    @Test
    public void should_notify_owner_that_the_hotel_is_full() throws Exception {

        PetHotel petHotel = new PetHotel();
        checkInSomePets(petHotel,PetHotel.MAX_HOTEL_CAPACITY );
        Pet bruno = Pet.dog().named("Bruno");
        BookingResponse bookingResponse = petHotel.checkIn(bruno);

        assertThat(bookingResponse.isConfirmed(), comparesEqualTo(false));
        assertThat(petHotel.getPets().values(), not(hasItem(bookingResponse.getPet())));
    }


    @Test
    public void should_place_pets_on_a_waiting_list_when_the_hotel_is_full() throws Exception {

        PetHotel petHotel = new PetHotel();
        checkInSomePets(petHotel,PetHotel.MAX_HOTEL_CAPACITY );
        Pet bruno = Pet.dog().named("Bruno");
        BookingResponse bookingResponse = petHotel.checkIn(bruno);

        assertThat(bookingResponse.onWaitingList(), comparesEqualTo(true));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_added_to_the_hotel_when_a_place_is_freed() throws Exception {

        PetHotel petHotel = new PetHotel();
        checkInSomePets(petHotel,PetHotel.MAX_HOTEL_CAPACITY - 1);
        Pet bruno = Pet.dog().named("Bruno");
        Pet fido = Pet.dog().named("Fido");
        petHotel.checkIn(bruno);
        petHotel.checkIn(fido);

        petHotel.checkOut(bruno.getName());

        assertThat(petHotel.getPets().values() , hasItem(fido));
    }

    @Test
    public void pets_on_the_waiting_list_should_be_admitted_on_a_first_come_first_served_basis() throws Exception {

        PetHotel petHotel = new PetHotel();
        checkInSomePets(petHotel,PetHotel.MAX_HOTEL_CAPACITY - 1);
        Pet bruno = Pet.dog().named("Bruno");
        Pet fido = Pet.dog().named("Fido");
        Pet funy = Pet.dog().named("Funy");

        petHotel.checkIn(bruno);
        petHotel.checkIn(fido);
        petHotel.checkIn(funy);
        petHotel.checkOut(bruno.getName());

        assertThat(petHotel.getPets().values() , hasItem(fido));
        assertThat(petHotel.getPets().values() , not(hasItem(funy)));

    }

    private List<BookingResponse> checkInSomePets(PetHotel petHotel, int petCount) {

        List<BookingResponse> petBookingResponse = Lists.newArrayList();
        for (int i = 0; i < petCount; i++) {
            Pet pet = Pet.dog().named("bruno"+i);
            BookingResponse bookingResponse = petHotel.checkIn(pet);
            petBookingResponse.add(bookingResponse);
        }
        return petBookingResponse;
    }
}
