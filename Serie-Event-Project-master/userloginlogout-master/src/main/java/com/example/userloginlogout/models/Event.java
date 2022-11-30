package com.example.userloginlogout.models;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;
    private String date;
    private int valeur;
    private String commentaire;
    private String tag_string;
    @ManyToOne
    @JoinColumn(name="serie_id")
    private Serie serie;
    @ManyToOne
    @JoinColumn(name="tag_id")
    private Tag tag;

    public Event()
    {

    }
    public Event(String date,int valeur,String commentaire,Serie serie)
    {
        this.date=date;
        this.valeur=valeur;
        this.commentaire=commentaire;
        this.serie=serie;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getValeur() {
            return valeur;
        }

        public void setValeur(int valeur) {
            this.valeur = valeur;
        }

        public String getCommentaire() {
            return commentaire;
        }

        public void setCommentaire(String commentaire) {
            this.commentaire = commentaire;
        }

    public String getTag_string() {
			return tag_string;
		}
		public void setTag_string(String tag_string) {
			this.tag_string = tag_string;
		}
		public Tag getTag() {
			return tag;
		}
		public void setTag(Tag tag) {
			this.tag = tag;
		}
	public Serie getSerie() {
            return serie;
        }

        public void setSerie(Serie serie) {
            this.serie = serie;
        }
    }
