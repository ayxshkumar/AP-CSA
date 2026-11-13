/*
 * Name:        Ayush Kumar
 * Partner:     None
 * Course:      AP Computer Science A, Period 5
 * Instructor:  Mr. Virak
 * Assignment:  2.05.2 - Smart Checkout
 * Due Date:    11/13/26
 *
 * Description: Checkout program that applies a coupon and a VIP loyalty
 *              discount. The coupon lookup can return null and the loyalty
 *              average can divide by zero, so every compounded condition 
 *              puts its safety check on the left and relies on short-circuit
 *              evaluation to skip the right side of an operator.
 */

import java.util.Scanner;

public class SmartCheckout {

    private static final int MIN_COUPON_PERCENT = 5;
    private static final int BIG_SAVER_PERCENT = 15;
    private static final int VIP_MIN_AVERAGE = 50;
    private static final double VIP_DISCOUNT = 5.00;

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);
        System.out.println("=== SMART CHECKOUT ===");

        double subtotal;
        String code;
        int visits;
        int points;
        double discount = 0.0;
        double total;

        System.out.print("Subtotal: $");
        subtotal = entry.nextDouble();

        System.out.print("Coupon code (or NONE): ");
        code = entry.next();

        System.out.print("Store visits this year: ");
        visits = entry.nextInt();

        System.out.print("Loyalty points earned: ");
        points = entry.nextInt();

        // WARNING: may be null
        Integer percent = couponPercent(code);

        // Guard 1 (||) prevents a NullPointerException. percent < 5 unboxes
        // percent, which crashes if it is null. Checking percent == null
        // first means a null coupon makes the || true, so Java never evaluates it.
        if (percent == null || percent < MIN_COUPON_PERCENT) {
            System.out.println("No coupon discount applied.");
        } else {
            discount = subtotal * percent / 100.0;
            System.out.println("Coupon applied: " + percent + "% off");
        }

        // Guard 2 (&&) prevents a NullPointerException. percent >= 15 unboxes
        // percent, which crashes if it is null. Checking percent != null
        // first means a null coupon makes the && false immediately, so Java
        // never evaluates percent >= 15 either.
        if (percent != null && percent >= BIG_SAVER_PERCENT) {
            System.out.println("Big saver! That's one of our best coupons.");
        }

        // Guard 3 (&&) prevents an ArithmeticException. points / visits is
        // integer division, which crashes when visits is 0. Checking
        // visits != 0 first means 0 visits makes the && false right away.
        boolean vip = visits != 0 && points / visits >= VIP_MIN_AVERAGE;

        if (vip) {
            discount += VIP_DISCOUNT;
            System.out.printf("VIP shopper: extra $%.2f off!%n", VIP_DISCOUNT);
        }

        total = subtotal - discount;

        System.out.printf("Subtotal:  $%8.2f%n", subtotal);
        System.out.printf("Discount: -$%8.2f%n", discount);
        System.out.printf("Total:     $%8.2f%n", total);

        entry.close();
    }

    // ===================== PROVIDED — DO NOT MODIFY =====================
    // Returns the percent off for a valid code, or null if the code is not valid
    public static Integer couponPercent(String code)
    {
        if (code.equalsIgnoreCase("SAVE10"))
        {
            return 10;
        }
        else if (code.equalsIgnoreCase("TEACHER"))
        {
            return 15;
        }
        else if (code.equalsIgnoreCase("PENNY"))
        {
            return 1;
        }
        return null;
    }
}

/*
 * TEST CASES
 * entry order: subtotal, coupon code, visits, points
 *
 * #  entry                    Purpose                   Expected output
 * -  -----------------------  ------------------------  ---------------------
 * 1  80.00, SAVE10, 4, 260    Valid coupon + VIP        10% off, VIP
 *                             (260 / 4 = 65)            Discount 13.00,
 *                                                       Total 67.00
 * 2  80.00, teacher, 0, 0     0 visits (no crash),      15% off, Big saver,
 *                             lowercase code, Big saver no VIP; Discount
 *                                                       12.00, Total 68.00
 * 3  25.50, NONE, 3, 149      Invalid code, not VIP     No coupon, no VIP;
 *                             (149 / 3 = 49)            Discount 0.00,
 *                                                       Total 25.50
 * 4  40.00, PENNY, 2, 60      PENNY coupon (1% < 5%)    No coupon, no VIP;
 *                             not VIP (60 / 2 = 30)     Discount 0.00,
 *                                                       Total 40.00
 * 5  50.00, BOGUS, 5, 300     Invalid code (null) +     No coupon, VIP;
 *                             VIP (300 / 5 = 60)        Discount 5.00,
 *                                                       Total 45.00
 * 6  30.00, BOGUS, 0, 100     null coupon AND 0 visits  No coupon, no VIP;
 *                             together (no crash)       Discount 0.00,
 *                                                       Total 30.00
 * 7  100.00, TEACHER, 10, 500 Big saver + VIP at the    15% off, Big saver,
 *                             boundary (500 / 10 = 50)  VIP; Discount 20.00,
 *                                                       Total 80.00
 *
 * All 7 cases were run and matched the expected output.
 */

/*
 * THINK ABOUT IT
 *
 * 1. 149 / 3 evaluates to 49. Both operands are ints, so Java does integer
 *    division and truncates the remainder (49.67 becomes 49). Since
 *    49 < 50, the shopper is not VIP status.
 *
 * 2. Guard 1 (no discount):  percent == null || percent < 5
 *    Coupon accepted = !(percent == null || percent < 5)
 *    =  percent != null && percent >= 5
 *    De Morgan's Laws flip || to && and negate each aspect (== becomes !=,
 *    < becomes >=). The null check is still on the left, so it stays safe.
 *
 * 3. System.out.println(10.0 / 0) prints Infinity. The 0 is promoted to
 *    0.0, and double math has special values for this : Infinity, 
 *    -Infinity, and NaN. The int type has no value that can represent
 *    infinity, so integer division by 0 has no possible answer and Java
 *    throws an ArithmeticException instead.
 */