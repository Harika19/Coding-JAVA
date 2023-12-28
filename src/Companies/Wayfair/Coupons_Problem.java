package Companies.Wayfair;

//We're given categories that are organized hierarchically and a list of coupons where each coupon can be applied to certain categories.
// Coupons are valid for child categories of categories it can be applied to.
//        First question: Given a category, return list of coupons applicable to that category.
//        Second question: Each coupon now has a validity period, return list of coupons application to given category on a particular date.


import java.util.*;

public class Coupons_Problem {

    static class Coupon {
        String CategoryName;
        String CouponName;

        Coupon(String CategoryName, String CouponName) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }

        @Override
        public String toString() {
            return "{ CategoryName: " + CategoryName + ", CouponName: " + CouponName + " }";
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

    Coupons_Problem() {
        this.parentMap = new HashMap<>();
        this.couponMap = new HashMap<>();
    }

    private List<Coupon> generateCoupons() {
        ArrayList<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon("Comforter Sets", "Comforters Sale"));
        coupons.add(new Coupon("Bedding", "Savings on Bedding"));
        coupons.add(new Coupon("Bed & Bath", "Low price for Bed & Bath"));

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


    public static void main(String[] args) throws Exception {
        Coupons_Problem obj = new Coupons_Problem();

        obj.storeDataToMap();
        System.out.println(Objects.equals(obj.getCouponForCategory("Comforter Sets"), "Comforters Sale"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Bedding"), "Savings on Bedding"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Bathroom Accessories"), "Low price for Bed & Bath"));
        System.out.println(Objects.equals(obj.getCouponForCategory("Soap Dispensers"), "Low price for Bed & Bath"));
        System.out.println(obj.getCouponForCategory("Toy Organizers") == null);
    }

}
