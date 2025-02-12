from pymongo import MongoClient
from bson.objectid import ObjectId


class AnimalShelter(object):
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, username, password):

        self.client = MongoClient(
            'mongodb://%s:%s@%s:%d' % ('aacuser', 'mongo7', 'nv-desktop-services.apporto.com', 31019))
        self.database = self.client['AAC']
        self.collection = self.database['%s' % ('animals')]

    def create(self, data):
        if data is not None:
            insert = self.database.animals.insert(data)
            if insert != 0:
                return True
            else:
                return False
        else:
            raise Exception("Nothing to save, because data parameter is empty")

    def read(self, search = None):
        if search:
            insert = self.database.animals.find(search, {"_id": False})

        else:
            query = self.database.animals.find({}, {"_id": False})
        return query

    def update(self, update_doc, amend):
        if update_doc is not None:
            result = self.database.animals.update_many(update_doc, {"$set": amend})

        else:
            result = "Error"

        return result.raw_result

    def delete(self, delete_doc):
        if delete_doc is not None:
            result = self.database.animals.delete_many(delete_doc)

        else:
            result = "Error"

        return result.raw_result
