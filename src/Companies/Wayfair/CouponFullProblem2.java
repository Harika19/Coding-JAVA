package Companies.Wayfair;

import java.text.ParseException;
import java.util.*;

/**
 * Given the following data set, find the coupon to display for a given category.
 *
 * Note: Category structure is hierarchical. Categories without coupons inherit their parent’s coupon.
 *
 * Data:
 * Coupons = [
 *      {"CategoryName":"Comforter Sets", "CouponName":"Comforters Sale"},
 *      {"CategoryName":"Bedding",        "CouponName":"Savings on Bedding"},
 *      {"CategoryName":"Bed & Bath",     "CouponName":"Low price for Bed & Bath"}
 * ]
 *
 * Categories = [
 *      {"CategoryName":"Comforter Sets",       "CategoryParentName":"Bedding"},
 *      {"CategoryName":"Bedding",              "CategoryParentName":"Bed & Bath"},
 *      {"CategoryName":"Bed & Bath",           "CategoryParentName":null},
 *      {"CategoryName":"Soap Dispensers",      "CategoryParentName":"Bathroom Accessories"},
 *      {"CategoryName":"Bathroom Accessories", "CategoryParentName":"Bed & Bath"},
 *      {"CategoryName":"Toy Organizers",       "CategoryParentName":"Baby And Kids"},
 *      {"CategoryName":"Baby And Kids",        "CategoryParentName":null}
 * ]
 *
 * Testcase:
 * => input(CategoryName) => output(CouponName)
 *      "Comforter Sets"       => "Comforters Sale"
 *      "Bedding"              => "Savings on Bedding"
 *      "Bathroom Accessories" => "Low price for Bed & Bath"
 *      "Soap Dispensers"      => "Low price for Bed & Bath"
 *      "Toy Organizers"       => null
 *
 * Followup Question
 *     The system has added a new piece of data to the coupon - “Date Modified”. Use this when resolving any ties.
 *
 * Coupons = [
 *      { "CategoryName":"Comforter Sets", "CouponName":"Comforters Sale", "DateModified":"2021-01-01" },
 *      { "CategoryName":"Comforter Sets", "CouponName":"Cozy Comforter Coupon", "DateModified":"2020-01-01" },
 *      { "CategoryName":"Bedding", "CouponName":"Best Bedding Bargains", "DateModified":"2019-01-01" },
 *      { "CategoryName":"Bedding", "CouponName":"Savings on Bedding", "DateModified":"2019-01-01" },
 *      { "CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath", "DateModified":"2018-01-01" },
 *      { "CategoryName":"Bed & Bath", "CouponName":"Bed & Bath extravaganza", "DateModified":"2019-01-01" },
 *      { "CategoryName":"Bed & Bath", "CouponName":"Big Savings for Bed & Bath", "DateModified":"2030-01-01" }
 * ]
 */
public class CouponFullProblem2 {

    static class Coupon {
        String CategoryName;
        String CouponName;
        String lastModifiedDate;

        Coupon(String CategoryName, String CouponName) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }

        public Coupon(String categoryName, String couponName, String lastModifiedDate) {
            CategoryName = categoryName;
            CouponName = couponName;
            this.lastModifiedDate = lastModifiedDate;
        }

        @Override
        public String toString() {
            return "{ CategoryName: " + CategoryName + ", CouponName: " + CouponName + ", lastModifiedDate: " + lastModifiedDate + " }\n";
        }
    }

    static class Category {
        String CategoryMame;
        String CategoryParentName;

        Category(String CategoryName, String CategoryParentName) {
            this.CategoryMame = CategoryName;
            this.CategoryParentName = CategoryParentName;
        }
    }

    private final Map<String, String> categoryMap;
    private final Map<String, String> couponMap;
    private final Map<String, List<Coupon>> couponWithDateMap;
    CouponFullProblem2() {
        this.categoryMap = new HashMap<>();
        this.couponMap = new HashMap<>();
        this.couponWithDateMap = new HashMap<>();
    }

    private List<Coupon> generateCoupons() {
        ArrayList<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon("Comforter Sets", "Comforters Sale"));
        coupons.add(new Coupon("Bedding", "Savings on Bedding"));
        coupons.add(new Coupon("Bed & Bath", "Low price for Bed & Bath"));

        System.out.println("......."+coupons);
        // below is not optimal solution, so use hashmap as TC = O(1)
//        String name = "Bed & Bath";
//        for(Coupon aCoupon: coupons){
//            System.out.println("111"+ aCoupon);
//            if(aCoupon.CategoryName.equals(name)){
//                System.out.println("hiii"+ aCoupon.CouponName);
//                break;
//            }
//        }

        return coupons;
    }

    private List<Coupon> generateCouponsWithDate() {
            List<Coupon> coupons = Arrays.asList(
                    new Coupon("Comforter Sets", "Comforters Sale", "2021-01-01"),
                    new Coupon("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"),
                    new Coupon("Bedding", "Savings on Bedding", "2019-11-01"),
                    new Coupon("Bedding", "Best Bedding Bargains", "2020-01-01"),
                    new Coupon("Bedding", "Latest Bedding", "2023-12-01"),
                    new Coupon("Bed & Bath", "Low price for Bed & Bath", "2018-01-01"),
                    new Coupon("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"),
                    new Coupon("Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01"));

            return coupons;

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
            categoryMap.putIfAbsent(aCategory.CategoryMame, aCategory.CategoryParentName);
        }
    }

    private String getCouponForCategory(String category) {

        while (category != null && !couponMap.containsKey(category)) {
            category = categoryMap.getOrDefault(category, null);
        }

        return couponMap.get(category);
    }

    private void storeDataIntoMapWithDate() throws Exception {
        for(Coupon coupon : generateCouponsWithDate()) {
            List<Coupon> couponList = couponWithDateMap.getOrDefault(coupon.CategoryName, new ArrayList<>());
            couponList.add(coupon);
            couponWithDateMap.put(coupon.CategoryName, couponList);

//            couponWithDateMap.computeIfAbsent(coupon.CategoryName, val -> new ArrayList<>()).add(coupon);
        }

        for(Category category : generateCategory()) {
            categoryMap.put(category.CategoryMame, category.CategoryParentName);
        }
    }

    private String getLatestCouponForGivenCategory(String category) {
        String result = null;

        while(category != null && !couponWithDateMap.containsKey(category)) {
            category = categoryMap.getOrDefault(category, null);
        }

        List<Coupon> couponList = couponWithDateMap.get(category);
        result = getLatestCoupon(couponList);

        return result;
    }

    private String getLatestCoupon(List<Coupon> couponList) {
        String currentDate = "2023-12-27";
        Coupon latestCoupon = couponList.get(0);

        for(int i=1; i<couponList.size(); i++) {
            Coupon currentCoupon = couponList.get(i);

            // Latest coupon till the currentDate
            if(currentCoupon.lastModifiedDate.compareTo(latestCoupon.lastModifiedDate) > 0
                    // Below condition is to avoid picking up future date coupons
                    && currentCoupon.lastModifiedDate.compareTo(currentDate) <= 0
                    && latestCoupon.lastModifiedDate.compareTo(currentDate) <= 0) {
                latestCoupon = currentCoupon;
            }
        }

        return latestCoupon.CouponName;
    }

    /*
    CurrDate = 2023-12-27

     [2023-12-26, 2022-12,23, 2023-12-27, 2023-12-28 , 2024-12-23, ....]
       cc
     */

    public static void main(String[] args) throws Exception {
        CouponFullProblem2 obj = new CouponFullProblem2();

        obj.storeDataToMap();
//
//        System.out.println(Objects.equals(obj.getCouponForCategory("Comforter Sets"), "Comforters Sale"));
//        System.out.println(Objects.equals(obj.getCouponForCategory("Bedding"), "Savings on Bedding"));
//        System.out.println(Objects.equals(obj.getCouponForCategory("Bathroom Accessories"), "Low price for Bed & Bath"));
//        System.out.println(Objects.equals(obj.getCouponForCategory("Soap Dispensers"), "Low price for Bed & Bath"));
//        System.out.println(obj.getCouponForCategory("Toy Organizers"));
//        System.out.println(obj.getCouponForCategory("Baby And Kids"));


        obj.storeDataIntoMapWithDate();
        System.out.println("=======");
        System.out.println(obj.categoryMap);
        System.out.println(obj.couponWithDateMap);
        System.out.println("=======");

        System.out.println(obj.getLatestCouponForGivenCategory("Comforter Sets"));
        System.out.println(obj.getLatestCouponForGivenCategory("Bed & Bath"));
        System.out.println(obj.getLatestCouponForGivenCategory("Bedding"));
    }
}
