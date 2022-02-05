public class MilitaryOffice {

    public Person[] peoples;


    public Person[] findByAddress(String country ) {
        Person[] result = new Person[peoples.length];
        for (int i = 0; i < peoples.length; i++) {
            Person person = peoples[i];
            if (person.getAddress() != null && country!= null && country.equals(person.getAddress().getCountry())){
                result[i] = person;
            }
        }return result;
    }

    public int countPeople(Address address) {
        int count = 0;
        for (Person person : peoples) {
            Address personsAddress = person.getAddress();
            if (personsAddress.getCountry().equals(address.getCountry())
                    && personsAddress.getCity().equals(address.getCity())) {
                count++;
            }
        }
        return count;
    }
}