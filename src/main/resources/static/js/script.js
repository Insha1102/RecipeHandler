$(document).ready(function() {
    $('#example').DataTable( {
        pageLength:10,
        ajax: {
        	url:'/api/recipies/retrieveall',
        	dataSrc: ''
        },
        columns: [
        
            {
            	
             	data:'id'
            },
            {
            	
             	data:'name'
            },
            {
            	
             	data:'indicator'
            },
            {
            	
             	data:'servings'
            },
            {
            
             	data:'ingredients'
            },
            {
            	
             	data:'instructions'
            },
        	{
            	data:'image',
                mRender: function(data, type, row){
                	return '<img src="/resources/images/' + data + '" class="dataTableImg"/>';
                }
            },
            {
            	data:'id',
            	render: function(data, type, full, meta){
                	return '<a href="add.html?project='+data+'" target="_blank">Edit</a>'
                }
            },
            {
            	data:'id',
            	render: function(data, type, full, meta){
                	return '<a onclick="deleteRecipe('+data+')">Delete</a>';
                }
            }
        ]
    } );
} );

function deleteRecipe(id){
	$.ajax({url: "/delete/"+id,
		type : 'DELETE',
		success: function(result){
			return result;
	  }});
}
