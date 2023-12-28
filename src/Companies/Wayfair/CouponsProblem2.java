package Companies.Wayfair;

/**
 *
 Given the following data set, find the coupon to display for a given category.


 Note: Category structure is hierarchical. Categories without coupons inherit their parent’s coupon.


 data

 Coupons = [

 {"CategoryName":"Comforter Sets", "CouponName":"Comforters Sale"},

 {"CategoryName":"Bedding", "CouponName":"Savings on Bedding"},

 {"CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath"}

 ]


 Categories = [

 {"CategoryName":"Comforter Sets", "CategoryParentName":"Bedding"},

 {"CategoryName":"Bedding", "CategoryParentName":"Bed & Bath"},

 {"CategoryName":"Bed & Bath", "CategoryParentName":null},

 {"CategoryName":"Soap Dispensers", "CategoryParentName":"Bathroom Accessories"},

 {"CategoryName":"Bathroom Accessories", "CategoryParentName":"Bed & Bath"},

 {"CategoryName":"Toy Organizers", "CategoryParentName":"Baby And Kids"},

 {"CategoryName":"Baby And Kids", "CategoryParentName":null}

 ]


 tests: input(CategoryName) => output(CouponName)

 "Comforter Sets" => "Comforters Sale"

 "Bedding" => "Savings on Bedding"

 "Bathroom Accessories" => "Low price for Bed & Bath"

 "Soap Dispensers" => "Low price for Bed & Bath"

 "Toy Organizers" => null


 Followup Question

 The system has added a new piece of data to the coupon - “Date Modified”. Use this when resolving any ties.


 Coupons = [


 { "CategoryName":"Comforter Sets", "CouponName":"Comforters Sale", "DateModified":"2021-01-01" },

 { "CategoryName":"Comforter Sets", "CouponName":"Cozy Comforter Coupon", "DateModified":"2020-01-01" },

 { "CategoryName":"Bedding", "CouponName":"Best Bedding Bargains", "DateModified":"2019-01-01" },

 { "CategoryName":"Bedding", "CouponName":"Savings on Bedding", "DateModified":"2019-01-01" },

 { "CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath", "DateModified":"2018-01-01" },

 { "CategoryName":"Bed & Bath", "CouponName":"Bed & Bath extravaganza", "DateModified":"2019-01-01" },

 { "CategoryName":"Bed & Bath", "CouponName":"Big Savings for Bed & Bath", "DateModified":"2030-01-01" }


 ]
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CouponsProblem2 {

    static class Coupon {
        String CategoryName;
        String CouponName;
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.ENGLISH);
        LocalDate DateModified;

        Coupon() {
            format = new SimpleDateFormat("yyyy-MM-dd");
        }

        Coupon(String CategoryName, String CouponName) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }

        Coupon(String CategoryName, String CouponName, String DateModified) throws ParseException {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
            this.date = format.parse(DateModified);
            this.DateModified = LocalDate.parse(DateModified, formatter);
        }

        @Override
        public String toString() {
            return "{ CategoryName: " + CategoryName + ", CouponName: " + CouponName + ", DateModified: " + DateModified + " }";
        }
    }

    class Category {
        String CategoryMame;
        String CategoryParentName;

        Category(String CategoryName, String CategoryParentName) {
            this.CategoryMame = CategoryName;
            this.CategoryParentName = CategoryParentName;
        }
    }

    private final Map<String, String> parentMap;
    private final Map<String, String> couponMap;
    private final Map<String, PriorityQueue<Coupon>> couponMapWithDate;

    CouponsProblem2() {
        this.parentMap = new HashMap<>();
        this.couponMap = new HashMap<>();
        this.couponMapWithDate = new HashMap<>();
    }

    private List<Coupon> generateCoupons() {
        ArrayList<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon("Comforter Sets", "Comforters Sale"));
        coupons.add(new Coupon("Bedding", "Savings on Bedding"));
        coupons.add(new Coupon("Bed & Bath", "Low price for Bed & Bath"));

        return coupons;
    }

    private List<Coupon> generateCouponsWithDate() throws Exception {
        try {
            List<Coupon> coupons = Arrays.asList(
                    new Coupon("Comforter Sets", "Comforters Sale", "2021-01-01"),
                    new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"),
                    new Coupon("Bedding", "Savings on Bedding", "2019-01-01"),
                    new Coupon("Bedding", "Best Bedding Bargains", "2019-01-01"),
                    new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01"),
                    new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"),
                    new Coupon("Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01"));

            System.out.println(coupons);
            return coupons;
        } catch (Exception exception) {
            System.err.println(" Exception occurred ");
            exception.printStackTrace();

            if (exception instanceof ParseException)
                throw new Exception(" Exception in parsing date ", exception);
            else
                throw exception;
        }
    }

    private List<Category> generateCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Comforter Sets", "Bedding"));
        categories.add(new Category("Bedding", "Bed & Bath"));
        categories.add(new Category("Bed & Bath", null));
        categories.add(new Category("Soap Dispensers", "Bathroom Accessories"));
        categories.add(new Category("Bathroom Accessories", "Bed & Bath"));
        categories.add(new Category("Toy Organizers", "Baby And Kids"));
        categories.add(new Category("Baby And Kids", null));

        return categories;
    }

    private void storeDataToMap() {
        for (Coupon aCoupon : generateCoupons()) {
            couponMap.putIfAbsent(aCoupon.CategoryName, aCoupon.CouponName);
        }

        for (Category aCategory : generateCategory()) {
            parentMap.putIfAbsent(aCategory.CategoryMame, aCategory.CategoryParentName);
        }
    }

    private void storeDataToMapWithDate() throws Exception {

        Comparator<Coupon> comparator = Comparator.comparing(o -> o.DateModified);

        Comparator<Coupon> reverseComparator = comparator.reversed();

        for (Coupon aCoupon : generateCouponsWithDate()) {
            couponMapWithDate.putIfAbsent(aCoupon.CategoryName, new PriorityQueue<>(reverseComparator));
            couponMapWithDate.get(aCoupon.CategoryName).add(aCoupon);
        }

        for (Category aCategory : generateCategory()) {
            parentMap.putIfAbsent(aCategory.CategoryMame, aCategory.CategoryParentName);
        }
    }

    private String getCouponForCategory(String category) {
        System.out.print(category);

        while (category != null && !couponMap.containsKey(category)) {
            category = parentMap.getOrDefault(category, null);
        }

        System.out.println(" --> " + (category != null ? couponMap.get(category) : null));

        return category != null ? couponMap.get(category) : null;
    }

    private ArrayList<String> getCouponForCategoryWithDate(String category, String date) {
        ArrayList<String> result = new ArrayList<>();
        LocalDate localDate = LocalDate.parse(date);

        String currCategory = category;
        while (currCategory != null && !couponMapWithDate.containsKey(currCategory)) {
            currCategory = parentMap.getOrDefault(currCategory, null);
        }

        for (Coupon currCoupon : couponMapWithDate.get(currCategory)) {
            if (currCoupon.DateModified.isBefore(localDate)) {
                break;
            } else {
                result.add(currCoupon.CouponName);
            }
        }

//         Code for most recent coupon and not in future

        int minDiff = Integer.MAX_VALUE;
        long minDiffLong = Long.MAX_VALUE;
        LocalDate currDate = LocalDate.now();
        String resultantCoupon = null;
        for(Coupon currCoupon: couponMapWithDate.get(currCategory)){
            Period period = Period.between(currDate, currCoupon.DateModified);
            int currDiff = period.getDays();

            long noOfDays = Duration.between(currDate.atStartOfDay(), currCoupon.DateModified.atStartOfDay()).toDays();

            System.out.println("===> noOfDays "+noOfDays+" "+currCoupon.DateModified+" "+currDate);
            if(noOfDays >=0 && noOfDays<minDiffLong){
                minDiffLong = noOfDays;
                resultantCoupon = currCoupon.CouponName;
            }

            System.out.println("===> Result coupon : "+resultantCoupon);

            System.out.println("===> currDiff "+currDiff+" "+currCoupon.DateModified+" "+currDate);
            if(currDiff >=0 && currDiff<minDiff) {
                minDiff = currDiff;
                resultantCoupon = currCoupon.CouponName;
//            System.out.println("===> $$$$ "+currDate.datesUntil(currCoupon.DateModified));
            }
        }

        System.out.println("===> Result coupon : "+resultantCoupon);

        System.out.println(category +" --> "+result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        CouponsProblem2 obj = new CouponsProblem2();

        obj.storeDataToMap();
        System.out.println(Objects.equals(obj.getCouponForCategory("Comforter Sets"), "Comforters Sale"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Bedding"), "Savings on Bedding"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Bathroom Accessories"), "Low price for Bed & Bath"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Soap Dispensers"), "Low price for Bed & Bath"));
        System.out.println(obj.getCouponForCategory("Toy Organizers") == null);


        obj.storeDataToMapWithDate();

        System.out.println("=======");
        obj.couponMapWithDate.forEach((k,v) -> {
            System.out.println("==> " +v);
        });

        System.out.println("=======");

        System.out.println(obj.getCouponForCategoryWithDate("Comforter Sets","2020-01-01" ));
        System.out.println(obj.getCouponForCategoryWithDate("Bed & Bath", "2019-12-01"));
        System.out.println(obj.getCouponForCategoryWithDate("Bedding", "2019-01-01"));
    }

}

