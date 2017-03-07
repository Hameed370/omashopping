$(function(){
	
	$('#mytable').DataTable( {
		ajax: {
	        url: '/oma/products/all/data',
	        dataSrc: ''
	    },
	    columns: [
	       
	        { data: 'id' },
	        { data: 'description' },
	        { data: 'pname' },
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<img src="/oma/resources/Images/'+ row.id +'.jpg" height="50" width="50">';
	            }
	        },
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<a class="btn btn-primary" href="/oma/show/'+row.id+'/product">View Item</a> &nbsp;<a class="btn btn-primary" href="'+data+'">Add To Cart</a> ';
	            }	
	        }
	        
	        
	    ]
	} );
	
	
	
});




$(function(){
	
	$('#mytableproduct').DataTable( {
		ajax: {
	        url: '/oma/products/all/data',
	        dataSrc: ''
	    },
	    columns: [
	       
	          {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<img src="/oma/resources/Images/'+ row.id +'.jpg" height="50" width="50">';
	            }
	        },
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<a class="btn btn-primary" href="/oma/show/'+row.id+'/product">View Item</a>';
	            }	
	        }
	        
	        
	    ]
	} );
	
	
	
});