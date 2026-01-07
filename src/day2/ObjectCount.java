package day2;

class ObjectCount {
    static int count = 0;

    ObjectCount() {
        count++;
    }

    public static void main(String[] args) {
        ObjectCount o1 = new ObjectCount();
        ObjectCount o2 = new ObjectCount();
        ObjectCount o3 = new ObjectCount();

        System.out.println("Number of objects created = " + count);
    }
}
