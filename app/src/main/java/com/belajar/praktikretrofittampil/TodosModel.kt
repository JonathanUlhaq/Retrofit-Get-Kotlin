package com.belajar.praktikretrofittampil

data class TodosModel(val todos:List<Data>) {
    data class Data(val id:String?, val todo:String?,val completed:String?)
}