import java.util.Scanner;



    public class user {

        private String name;

        private String companyName;

        private int yearOfJoining;

        private String email;

        private String password;



        public user(String name, String companyName, int yearOfJoining) {

            this.name = name;

            this.companyName = companyName;

            this.yearOfJoining = yearOfJoining;

            this.email = createUserEmail();

            this.password = createUserPassword();

        }



        private static int generateRandomIntegerFromLimit(int limit) {

            return (int) (Math.random() * (limit));

        }



        private String createUserPassword() {

            StringBuilder sb = new StringBuilder();

            sb.append(generateRandomCharacter());

            for (int i = 0; i < 4; i++) {

                sb.append(generateRandomIntegerFromLimit(10));

            }

            sb.append(getFirst5CharactersFromUserName());

            sb.append(generateRandomSpecialSymbol());

            return sb.toString();

        }



        private String createUserEmail() {

            return String.format("%s_%d@%s.com",

                    getName().toLowerCase(), getYearOfJoining(), getCompanyName().toLowerCase());

        }



        public String getName() {

            return name;

        }



        public void setName(String name) {

            this.name = name;

        }



        public String getCompanyName() {

            return companyName;

        }



        public void setCompanyName(String companyName) {

            this.companyName = companyName;

        }



        public int getYearOfJoining() {

            return yearOfJoining;

        }



        public void setYearOfJoining(int yearOfJoining) {

            this.yearOfJoining = yearOfJoining;

        }



        public String getEmail() {

            return email;

        }



        public void setEmail(String email) {

            this.email = email;

        }



        public String getPassword() {

            return password;

        }



        public void setPassword(String password) {

            this.password = password;

        }



        private String getFirst5CharactersFromUserName() {

            if (getName().length() < 5) {

                int difference = 5 - getName().length();

                return (getName() + "0".repeat(Math.max(0, difference))).toLowerCase();

            } else {

                return getName().substring(0, 5);

            }

        }



        private char generateRandomSpecialSymbol() {

            char[] specialSymbols =

                    {

                            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',

                            '{', '}', '[', ']', '|', '\\', ';', ':', '\'', '\"',

                            '<', '>', ',', '.', '?', '/'

                    };

            int randomInteger = generateRandomIntegerFromLimit(specialSymbols.length);

            return specialSymbols[randomInteger];

        }



        private char generateRandomCharacter() {

            int randomNumberUpto26 = generateRandomIntegerFromLimit(26);

            return (char) ('a' + randomNumberUpto26);

        }

    }



    class userEntry {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            String userName = scanner.nextLine();

            String companyName = scanner.nextLine();

            int yearOfJoining = scanner.nextInt();

            user User = new user(userName, companyName, yearOfJoining);

            System.out.println("Email: " + User.getEmail() + "\nPassword: " + User.getPassword());

            scanner.close();

        }

    }

