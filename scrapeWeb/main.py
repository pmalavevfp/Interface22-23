import requests
from bs4 import BeautifulSoup

count=0
URL = "https://remote.co/remote-jobs/developer/"
page = requests.get(URL)

soup = BeautifulSoup(page.content, "html.parser")

#print(page.text)

# results = soup.find("div class", class_="card border-0 p-3 job-card bg-white")
results = soup.find("div", class_="card bg-white m-0")
#print(results)

#job_elements = results.find_all("a", class_="card m-0 border-left-0 border-right-0 border-top-0 border-bottom")
job_elements = results.find_all("div", class_="col position-static")
#print (job_elements)
for job_element in job_elements:
    print(job_element, end="\n"*2)

print ("Cantidad de ofertas de trabajo son",len(job_elements))

kind_elements = results.find_all("span", class_="font-weight-bold larger")
company_elements = results.find_all("p", class_="m-0 text-secondary")

#location_elements = results.find_all("span", class_="badge badge-success")

kindJobs=[]
companies=[]
locations=[]

for kind in kind_elements:
    kindJobs.append(kind.text.strip())

print (kindJobs)

for company in company_elements:
    company = company.text.replace("\n", " ")
    company = company.replace("\xa0", " ")
    end=company.index("|")
    companies.append(company[:end].strip())
    location=company[end:]
    locations.append(location.strip())
    companies.append(locations)

    """results_loc = soup.find("span", class_="badge badge-success")
    location_elements = results_loc.find_all("span", class_="badge badge-success")
    for location in location_elements:
        # end=location.index("|")
        locations.append(location.text.strip())
    companies.append(locations)"""
print(companies)

"""
for location in location_elements:
    #end=location.index("|")
    locations.append(location.text.strip())
print(locations)
"""


print ("-------------------------------------------------------------------------------------------------")

for job_element in job_elements:
    kind_element = job_element.find("span", class_="font-weight-bold larger")
    company_element = job_element.find("p", class_="m-0 text-secondary")
    location_element = job_element.find("span", class_="badge badge-success")
    print(kind_element.text.strip())
    print(company_element.text.strip())
    print(location_element.text.strip())
    print()

if "lemon" in (company_element.text.strip()):
    print(kind_element.text.strip())
    print(company_element.text.strip())
    count+=1
    print()


for job_element in job_elements:
    kind_element = job_element.find("span", class_="font-weight-bold larger")
    company_element = job_element.find("p", class_="m-0 text-secondary")

    location_element = job_element.find("span", class_="badge badge-success")
    if "lemon" in (company_element.text.strip()):
        print(kind_element.text.strip())
        print(company_element.text.strip())
        count+=1
        print()




print("lemon.io_jobs ",count)



"""
python_job_elements = [
    h2_element.parent.parent.parent for h2_element in python_jobs
]

for job_element in python_job_elements:
    # -- snip --
    links = job_element.find_all("a")
    for link in links:
        print(link.text.strip())

for job_element in python_job_elements:
    # -- snip --
    links = job_element.find_all("a")
    for link in links:
        link_url = link["href"]
        print(f"Apply here: {link_url}\n")

for job_element in python_job_elements:
    link_url = job_element.find_all("a")[1]["href"]
    print(f"Apply here: {link_url}\n")"""
