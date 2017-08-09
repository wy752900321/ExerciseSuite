# -*- coding=utf-8 -*-
import json

def check_json_format(raw_msg):
    """
    用于判断一个字符串是否符合Json格式
    :param self:
    :return:
    """
    if isinstance(raw_msg, str):       # 首先判断变量是否为字符串
        try:
            json.loads(raw_msg, encoding='utf-8')
        except ValueError:
            return False
        return True
    else:
        return False

if __name__ == "__main__":
    print check_json_format("""{"a":1}""")
    print check_json_format("""{'a':1}""")
    print check_json_format({'a': 1})
    print check_json_format(100)

