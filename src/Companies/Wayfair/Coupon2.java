package Companies.Wayfair;

import java.util.*;

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
//Coupons = [
//
//
//        { "CategoryName":"Comforter Sets", "CouponName":"Comforters Sale", "DateModified":"2021-01-01" },
//
//        { "CategoryName":"Comforter Sets", "CouponName":"Cozy Comforter Coupon", "DateModified":"2020-01-01" },
//
//        { "CategoryName":"Bedding", "CouponName":"Best Bedding Bargains", "DateModified":"2019-01-01" },
//
//        { "CategoryName":"Bedding", "CouponName":"Savings on Bedding", "DateModified":"2019-01-01" },
//
//        { "CategoryName":"Bed & Bath", "CouponName":"Low price for Bed & Bath", "DateModified":"2018-01-01" },
//
//        { "CategoryName":"Bed & Bath", "CouponName":"Bed & Bath extravaganza", "DateModified":"2019-01-01" },
//
//        { "CategoryName":"Bed & Bath", "CouponName":"Big Savings for Bed & Bath", "DateModified":"2030-01-01" }
//
//
//        ]

public class Coupon2 {
    private final Map<String ,String> couponMap;
    private final Map<String ,String> categotyMap;

    public Coupon2() {
        this.couponMap = new HashMap<>();
        this.categotyMap = new HashMap<>();
        this.couponWithDateMap = new HashMap<>();
    }

    class Coupons{
        String CategoryName;
        String CouponName;
        String  lastModified;

        public Coupons(String CategoryName, String CouponName) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
        }
        public Coupons(String CategoryName, String CouponName, String lastModified) {
            this.CategoryName = CategoryName;
            this.CouponName = CouponName;
            this.lastModified= lastModified;
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



    // =======================================================second problem===================

    private final Map<String ,List<Coupons>> couponWithDateMap;
    private ArrayList<Coupons> generateCouponWithDate(){
        ArrayList<Coupons> coupons = new ArrayList<>();

        coupons.add(new Coupons("Comforter Sets", "Comforters Sale", "2021-01-01"));
        coupons.add(new Coupons("Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"));
        coupons.add(new Coupons("Bedding", "Best Bedding Bargains", "2019-01-01"));
        coupons.add(new Coupons("Bedding", "Savings on Bedding", "2022-01-01"));
        coupons.add(new Coupons("Bed & Bath", "Low price for Bed & Bath", "2018-01-01"));
        coupons.add(new Coupons("Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"));
        coupons.add(new Coupons("Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01"));


        return coupons;
    }


    private void storeInMapWithDate(){
        for (Coupons aCouponWithDate: generateCouponWithDate()){
            List<Coupons> couponList =  couponWithDateMap.getOrDefault(aCouponWithDate.CategoryName, new ArrayList<>());
            couponList.add(aCouponWithDate);
            couponWithDateMap.put(aCouponWithDate.CategoryName, couponList);
        }
        for(Categories aCategory: generateCategory()){
            categotyMap.putIfAbsent(aCategory.CategoryName, aCategory.CategoryParentName);
        }
    }

    private String getCouponNameForDate(String categoryName){
        try{
            String result = null;

            while (categoryName!=null && !couponWithDateMap.containsKey(categoryName)){
                categoryName = categotyMap.getOrDefault(categoryName, null);
            }
            List<Coupons> couponList = couponWithDateMap.getOrDefault(categoryName, null);
            result = getLatestCoupon(couponList);
            return result;
        } catch (Exception exception){
            System.out.println("wrong cateogery name");
            return null;
        }

    }

    private String getLatestCoupon(List<Coupons> couponsList){
        String currDate = "2023-12-28";
        Coupons latestCoupon = couponsList.get(0);
        for(int i=1;i< couponsList.size();i++){
            Coupons currCoupon = couponsList.get(i);
            if(currCoupon.lastModified.compareTo(latestCoupon.lastModified)>0 &&
            currCoupon.lastModified.compareTo(currDate)<=0 &&
            latestCoupon.lastModified.compareTo(currDate)<=0){
                latestCoupon = currCoupon;
            }
        }
        return latestCoupon.CouponName;

    }
    public static void main(String[] args) {
        Coupon2 obj = new Coupon2();
        obj.storeInMap();
        System.out.println(obj.getCouponName("Soap Dispensers"));
        System.out.println(obj.getCouponName("Bedding"));
        System.out.println(obj.getCouponName("Toy Organizers"));
        System.out.println(obj.getCouponName("Comforter Sets"));
        System.out.println("===============");
        obj.storeInMapWithDate();
        System.out.println(obj.getCouponNameForDate("Comforter Sets"));
        System.out.println(obj.getCouponNameForDate("Bed & Bath"));
        System.out.println(obj.getCouponNameForDate("Bedding"));
        System.out.println(obj.getCouponNameForDate("Bedding1"));

    }
}
