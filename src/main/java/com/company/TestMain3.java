package com.company;

public class TestMain3 {
//
//    public static void main(String[] args) {
//        String password = PasswordField.readPassword("Enter password: ");
//        System.out.println("Password entered was:" + password);
//
//    }
//}
//
//
//class PasswordField {
//
//    public static String readPassword (String prompt) {
//        EraserThread et = new EraserThread(prompt);
//        Thread mask = new Thread(et);
//        mask.start();
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String password = "*";
//
//        try {
//            password = in.readLine();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        et.stopMasking();
//        return password;
//    }
//}
//
//class EraserThread implements Runnable {
//    private boolean stop;
//
//    public EraserThread(String prompt) {
//        System.out.print(prompt);
//    }
//
//    public void run () {
//        while (!stop){
//            System.out.print("\010 ");
//            try {
//                Thread.sleep(1);
//            } catch(InterruptedException ie) {
//                ie.printStackTrace();
//            }
//        }
//    }
//
//    public void stopMasking() {
//        this.stop = true;
//    }
//
}
