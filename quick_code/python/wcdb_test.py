# def search(request, query):
#   if(request.method == 'GET'):
#     class_attr_dict = {
#       Crisis : ['name', 'kind', 'description'],
#       Person : ['name', 'kind', 'description'],
#       Organization : ['name', 'kind', 'description']
#     }
#     json_data = json.dumps(search_everything(query, class_attr_dict))
#     return(HttpResponse(json_data, content_type='application/json'))
#   else:
#     return(HttpResponseNotAllowed(['GET']))

class_attr_dict = {
      Crisis : ['name', 'kind', 'description'],
      Person : ['name', 'kind', 'description'],
      Organization : ['name', 'kind', 'description']
    }


print class_attr_dict