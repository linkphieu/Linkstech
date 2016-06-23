package com.linkstech.object;

/**
 * Created by Link Larkin on 6/22/2016.
 */
public class ProductObject {

    private int id;
    private int userId;
    private String userScreenName;
    private String show;
    private long price;
    private String priceUnit;
    private String liked;
    private int commentCount;
    private double lat;
    private double lon;
    private double distance;
    private String distanceUnit;
    
    public ProductObject() {
    }

    public ProductObject(int id, int userId, String userScreenName, String show, long price, String priceUnit, String like, int commentCount, double lat, double lon, double distance, String distanceUnit) {
        this.id = id;
        this.userId = userId;
        this.userScreenName = userScreenName;
        this.show = show;
        this.price = price;
        this.priceUnit = priceUnit;
        this.liked = like;
        this.commentCount = commentCount;
        this.lat = lat;
        this.lon = lon;
        this.distance = distance;
        this.distanceUnit = distanceUnit;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getLike() {
        return liked;
    }

    public void setLike(String like) {
        this.liked = like;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }
    
}
