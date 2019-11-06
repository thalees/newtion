from flask import Flask, jsonify, request
from sklearn.svm import LinearSVC
import numpy as np
def train_algorithm(): 
    reader1 = [1,1,0,1,1,0]
    reader2 = [1,0,1,0,0,1]
    reader3 = [0,1,1,1,0,1]
    reader4 = [1,1,0,1,0,0]

    train_x = [reader1, reader2, reader3, reader4]
    train_y = [0, 1, 2, 3]

    model = LinearSVC()
    model.fit(train_x, train_y)

    return model

def predict_profile(profile):
    model_trained = train_algorithm()
    predictions = model_trained.predict(profile)

    if predictions == 1:
        return { 'profile': 'leitor em geral', 'readerTypeId': 1 }
    elif predictions == 2: 
        return { 'profile': "leitor de tecnologia e noticias", 'readerTypeId': 2 }
    elif predictions == 3: 
        return { 'profile': 'gosta de tecnologia e entretenimento', 'readerTypeId': 3 }
    else:
        return { 'profile': 'leitor de esportes', 'readerTypeId': 4 }        


app = Flask(__name__)

@app.route('/', methods=['POST'])
def get_profile_predicted(): 
    profile_to_predict = request.get_json() 
    return jsonify(predict_profile(([profile_to_predict]))), 200

if __name__ == '__main__':
    app.run(debug=True)