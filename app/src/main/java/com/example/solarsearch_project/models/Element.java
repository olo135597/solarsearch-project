package com.example.solarsearch_project.models;

public class Element {
    String id;
    String name;
    String[] moons;

    String massValue;
    String massExponent;
    double gravity;
    double density;
    int polarRadius;
    int equaRadius;
    String discoveredBy;
    String discoveryDate;
    String bodyType;

    public Element(String id, String name, String[] moons, double gravity, double density, int polarRadius, int equaRadius, String discoveredBy, String discoveryDate, String bodyType, String massValue, String massExponent) {
        this.id = id;
        this.name = name;
        this.moons = moons;
        this.gravity = gravity;
        this.density = density;
        this.polarRadius = polarRadius;
        this.equaRadius = equaRadius;
        this.discoveredBy = discoveredBy;
        this.discoveryDate = discoveryDate;
        this.bodyType = bodyType;
        this.massValue = massValue;
        this.massExponent = massExponent;
    }

    public Element() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMoons() {
        return moons;
    }

    public void setMoons(String[] moons) {
        this.moons = moons;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public String getMassValue() {
        return massValue;
    }

    public void setMassValue(String massValue) {
        this.massValue = massValue;
    }

    public String getMassExponent() {
        return massExponent;
    }

    public void setMassExponent(String massExponent) {
        this.massExponent = massExponent;
    }

    public int getPolarRadius() {
        return polarRadius;
    }

    public void setPolarRadius(int polarRadius) {
        this.polarRadius = polarRadius;
    }

    public int getEquaRadius() {
        return equaRadius;
    }

    public void setEquaRadius(int equaRadius) {
        this.equaRadius = equaRadius;
    }

    public String getDiscoveredBy() {
        return discoveredBy;
    }

    public void setDiscoveredBy(String discoveredBy) {
        this.discoveredBy = discoveredBy;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return id;
    }

}
