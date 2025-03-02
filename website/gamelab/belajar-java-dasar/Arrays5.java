class Main {
    public static void main(String[] args) {
        String[] mobil = {"Toyota", "Honda", "Tesla"};
        boolean found = false;
        String searchedValue = "Tesla";

        for(String x : mobil){
            if(x.equals(searchedValue)){
                found = true;
                break;
            }
        }

        System.out.println(found);
    }
}
