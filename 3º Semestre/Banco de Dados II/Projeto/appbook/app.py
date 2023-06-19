from flask import (
    Flask, render_template, request, redirect, url_for, flash
)
from pymongo import MongoClient
from dotenv import load_dotenv
import os
load_dotenv()

app = Flask(__name__)
app.config['SECRET_KEY'] = 'asdf0001'

cluster_url = os.getenv("CLUSTER_URL")
cluster = MongoClient(cluster_url)


def get_collection():
    db = cluster["db_books"]
    col = db["books"]
    return col

# ==================================
# ROTAS
# ==================================


@app.route("/")
def index():
    return render_template('index.html')


@app.route("/books/index", methods=["GET"])
def books_index():
    col = get_collection()
    # res = col.find({"title": "iPhone in Action"})
    res = col.find(
        {"title": {"$regex": "iPhone"}}
    )
    books = list(res)
    return render_template("books_list.html", books=books)


if __name__ == "__main__":
    app.run(debug=True)
