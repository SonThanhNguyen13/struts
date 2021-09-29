/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sonthanhnguyen
 */
public class book {

    private int id;
    private String name;
    private String author;
    private String description;
    private String image;

    public book(int id, String name, String author, String description, String avatar) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.image = avatar;
    }

    public book() {
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString(){
        return String.valueOf(id) + ";" + this.name  + ";" + this.author + ";" + this.description + ";" + this.image;
    }

}
