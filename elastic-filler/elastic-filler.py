import uuid
import json

import requests

with open('source.txt') as fh:
    joke = []
    for line in fh.readlines():
        if line != '\n':
            joke.append(line)
        else:
            if len(joke) > 0:
                guid = uuid.uuid4()
                # print(guid)
                message_joke = json.dumps({'joke': ''.join(joke)})
                # print(message_joke)
                ans = requests.post(
                    f'http://192.168.0.108:9200/jokes-index/_create/{guid}',
                    data=message_joke,
                    headers={'Content-Type': 'application/json'}
                )
                print(ans.status_code)
                # print(ans.content)
                joke = []
