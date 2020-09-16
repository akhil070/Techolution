import json
from pprint import pprint
import string
from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def main():
    student_file = open('data.json', )
    data = json.load(student_file)
    dataset = []
    for i in range(len(data)):
        tot_marks = 0
        flag = False
        for sub in data[i]['marks']:
            mark = int(data[i]['marks'][sub])
            if mark < 20:
                flag = True
            tot_marks += mark
        name = data[i]['name']
        rollnum = data[i]['rollNumber']
        isNotvalid = validate(name,rollnum)
        if isNotvalid:
            return render_template('Error.html',message="Error in json data please check and submit again!")
        student = [name] + [rollnum] + [tot_marks]
        if flag:
            student.append('Fail')
        elif tot_marks > 120:
            student.append('Topper')
        else:
            student.append('Pass')
        dataset.append(student)
    dataset.sort(key=lambda x:x[0])
    # pprint(dataset)
    return render_template('Home.html', dataset=dataset)

def validate(name,rollnum):
    special_chars = set(string.punctuation)
    acceted_chars = string.ascii_letters
    special_chars.remove('-')
    for x in name:
        if x in special_chars or (x not in acceted_chars):
            return True
    for x in rollnum:
        if x in special_chars:
            return True
    return False

if __name__ == '__main__':
    app.debug = True
    app.run(host='localhost', port=5010)
