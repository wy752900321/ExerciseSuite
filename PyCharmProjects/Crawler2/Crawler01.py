import datetime
import re
import sys
import time
from imp import reload

import urllib2
import lxml
from bs4 import BeautifulSoup
def getMobileLoc(p_mobile_seg):
    try:
        v_mobile_seg = "1375827"
        # v_mobile_seg = p_mobile_seg
        search_url = "http://www.ip138.com:8080/search.asp?mobile=" + v_mobile_seg + "&action=mobile"
        print search_url
        # response = urllib2.urlopen(search_url)


        header = {
            'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36.'}
        req = urllib2.Request(url='http://www.ip138.com:8080/search.asp?mobile=15120038022&action=mobile',
                              headers=header)

        response = urllib2.urlopen(req)
        html = response.read()
        # html = response.readlines()
        # print html
        soup = BeautifulSoup(html, "lxml", from_encoding="GB2312")
        # print soup.prettify('utf-8')
        allTdSoup = soup.find_all("td", class_="tdc2")
        mobile_str = ""
        for eachTdSoup in allTdSoup:
            #        print "eachTdSoup.renderContents()=",eachTdSoup.renderContents();
            mobile_str += "|" + eachTdSoup.renderContents();
            #    print "\n"

        print mobile_str
        mobile_seg = v_mobile_seg
        reg = re.compile(r"\|")
        finded = map(lambda n: n[0], reg.findall(mobile_str))
        finded_cnt = len(finded)
        if finded_cnt == 5:
            response = mobile_str.split('|', 5)
            phone_prov_city = response[2].replace('<!-- <td></td> -->', '')
            phone_prov_list = phone_prov_city.split(' ', 2)
            phone_prov = phone_prov_list[0]
            phone_city = phone_prov_list[1].replace('shi', '')
            #        print "\n"
            #        print mobile_seg
            #        print phone_prov_city
            #        print phone_prov
            #        print phone_city

            print datetime.datetime.now().strftime(
                "%Y%m%d%H%M%S") + " : Line " + '%d' % i + " : " + mobile_seg + '|' + phone_prov + '|' + phone_city
            print  datetime.datetime.now().strftime("%Y%m%d%H%M%S") + " : " + search_url
            f1.write(mobile_seg + '|' + phone_prov + '|' + phone_city + '\n')
        else:
            print mobile_str
            f2.write(mobile_str)
    except Exception as e:
        f2.write(v_mobile_seg + '|' + search_url + '\n')
        print e


if __name__ == "__main__":
    reload(sys)
    f = open('F:\\test\\testphone_list.txt', "r")
    f1 = open('F:\\test\\testphone_list_result.txt', "w")
    f2 = open('F:\\test\\testphone_list_excpt.txt', "w")
    f1.truncate()
    f2.truncate()
    i = 1
    while True:
        p_mobile = f.readline()
        print p_mobile
        p_mobile = p_mobile.replace('\n', '')
        time.sleep(6);
        getMobileLoc(p_mobile)
        i += 1
        if not p_mobile:
            break
    print "Finish!!!"
    f.close()
    f1.close()
    f2.close()
