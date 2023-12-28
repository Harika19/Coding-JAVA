package Companies.Wayfair;


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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponsProblem1Practice {
    private final Map<String, String> couponMap;
    private final Map<String, String> categoryMap;

    CouponsProblem1Practice(){
        this.couponMap = new HashMap<>();
        this.categoryMap= new HashMap<>();
    }

    class Coupons {
        String CategoryName;
        String CouponName;
        Coupons(String CategoryName, String CouponName){
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }
    }

    class Categories {
        String CategoryName;
        String CategoryParentName;
        Categories(String CategoryName, String CategoryParentName){
            this.CategoryName = CategoryName;
            this.CategoryParentName = CategoryParentName;
        }
    }

    private List<Coupons> generateCoupons(){
        ArrayList<Coupons> coupon = new ArrayList<>();
        coupon.add(new Coupons("Comforter Sets","Comforters Sale" ));
        coupon.add(new Coupons("Bedding","Savings on Bedding" ));
        coupon.add(new Coupons("Bed & Bath","Low price for Bed & Bath" ));

        return coupon;
    }

    private List<Categories> generateCategories(){
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

    private void storeInMap(){
        for(Coupons aCoupon: generateCoupons()){
            couponMap.putIfAbsent(aCoupon.CategoryName, aCoupon.CouponName);
        }
        for(Categories aCategory: generateCategories()){
            categoryMap.putIfAbsent(aCategory.CategoryName, aCategory.CategoryParentName);
        }
    }

    private String getCouponOfCategory(String category){
        while(category !=null && !couponMap.containsKey(category)){
            category = categoryMap.getOrDefault(category, null);
        }

        return (category!=null)? couponMap.getOrDefault(category, null): null;
    }

    public static void main(String[] args) {
        CouponsProblem1Practice obj = new CouponsProblem1Practice();
        obj.storeInMap();
        System.out.println(obj.getCouponOfCategory("Comforter Sets"));
        System.out.println(obj.getCouponOfCategory("Soap Dispensers"));
        System.out.println(obj.getCouponOfCategory("Bed & Bath"));
        System.out.println(obj.getCouponOfCategory("Baby And Kids"));
        System.out.println(obj.getCouponOfCategory("Toy Organizers"));
    }
}
