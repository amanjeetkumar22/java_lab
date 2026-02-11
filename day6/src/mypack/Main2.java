package mypack;
     class Bank {

        String bankName = "State Bank of India";   // non-static member
        static double rate = 5.0;                  // static member

        // Static nested class
        static class InterestCalculator {

            // Static method to calculate Simple Interest
            static double calculateSI(double p, double t) {
                // ❌ Cannot access non-static member directly
                // System.out.println(bankName);  // Compilation error

                // ✅ Can access static members of outer class
                return (p * t * rate) / 100;
            }
        }

        public static void main(String[] args) {
            double si = InterestCalculator.calculateSI(1000, 2);
            System.out.println("Simple Interest = " + si);
        }
    }


