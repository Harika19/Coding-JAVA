package Companies.Wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Coupons = [
//        {"CategoryName":"Comforter Sets", "CouponName":"Comforters Sale"},
//        {"CategoryName":"Bedding", "CouponName":"Savings on Bedding"},
//        {"CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath"}
//        ]
//
//
//        Categories = [
//        {"CategoryName":"Comforter Sets", "CategoryParentName":"Bedding"},
//        {"CategoryName":"Bedding", "CategoryParentName":"Bed & Bath"},
//        {"CategoryName":"Bed & Bath", "CategoryParentName":null},
//        {"CategoryName":"Soap Dispensers", "CategoryParentName":"Bathroom Accessories"},
//        {"CategoryName":"Bathroom Accessories", "CategoryParentName":"Bed & Bath"},
//        {"CategoryName":"Toy Organizers", "CategoryParentName":"Baby And Kids"},
//        {"CategoryName":"Baby And Kids", "CategoryParentName":null}
//        ]
// 4:10
public class Coupon1 {
    private final Map<String ,String> couponMap;
    private final Map<String ,String> categotyMap;

    public Coupon1() {
        this.couponMap = new HashMap<>();
        this.categotyMap = new HashMap<>();
    }

    class Coupons{
        String CategoryName;
        String CouponName;

        public Coupons(String CategoryName, String CouponName) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }
    }

    class Categories{
        String CategoryName;
        String CategoryParentName;

        public Categories(String CategoryName, String CategoryParentName) {
            this.CategoryName = CategoryName;
            this.CategoryParentName = CategoryParentName;
        }
    }

    private ArrayList<Coupons> generateCoupon(){
        ArrayList<Coupons> coupons = new ArrayList<>();
        coupons.add(new Coupons("Comforter Sets", "Comforters Sale"));
        coupons.add(new Coupons("Bedding", "Savings on Bedding"));
        coupons.add(new Coupons("Bed & Bath", "Low price for Bed & Bath"));

        return coupons;
    }

    private ArrayList<Categories> generateCategory(){
        ArrayList<Categories> categories = new ArrayList<>();
        categories.add(new Categories("Comforter Sets", "Bedding"));
        categories.add(new Categories("Bedding", "Bed & Bath"));
        categories.add(new Categories("Bed & Bath", null));
        categories.add(new Categories("Soap Dispensers", "Bathroom Accessories"));
        categories.add(new Categories("Bathroom Accessories", "Bed & Bath"));
        categories.add(new Categories("Toy Organizers", "Baby And Kids"));
        categories.add(new Categories("Baby And Kids", null));

        return categories;
    }

    private void  storeInMap(){
        for(Coupons aCoupon: generateCoupon()){
            couponMap.putIfAbsent(aCoupon.CategoryName, aCoupon.CouponName);
        }

        for(Categories aCategory: generateCategory()){
            categotyMap.putIfAbsent(aCategory.CategoryName, aCategory.CategoryParentName);
        }
    }

    private String getCouponName(String categoryName){
        while (categoryName!=null && !couponMap.containsKey(categoryName)){
            categoryName = categotyMap.getOrDefault(categoryName, null);
        }

        return (categoryName!=null)? couponMap.get(categoryName): null;
    }
    public static void main(String[] args) {
        Coupon1 obj = new Coupon1();
        obj.storeInMap();
        System.out.println(obj.getCouponName("Soap Dispensers"));
        System.out.println(obj.getCouponName("Bedding"));
        System.out.println(obj.getCouponName("Toy Organizers"));
        System.out.println(obj.getCouponName("Comforter Sets"));



    }
}
