<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<script>
$(function(){
	
	$('#adminproduct').DataTable( {
		ajax: {
	        url: '/omashoppingfront/myadmin/products/all',
	        dataSrc: ''
	    },
	    columns: [
	       
	        { data: 'id' },
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<img src="/omashoppingfront/resources/images/'+ row.id +'.jpg" height="50" width="50">';
	            }
	        },
	        { data: 'pname' },
	        { data: 'description' },
	        {data: 'price'},
	        {data:'qty'},
	        {data: null,
	        	mRender: function ( data, type, row ) {
	                return '<a class="btn btn-primary" href="/omashoppingfront/myadmin/edit/product/'+row.id+'">Edit Item</a>&nbsp;<a class="btn btn-primary" href="/edit/'+row.id+'/">Delete Item</a> ';
	            }	
	        }
	        
	        
	    ]
	} );
	
	
	
});


</script>




<div class="container">
<div class="row">
<button class="btn btn-success">Add Product</button>

</div>

<div style="height:15px"></div>

<div class="container">
	<div class="row">
		<table id="adminproduct" class="table table-striped">
			<thead>
				<th>PTAG</th>
				<th>Image</th>
				<th>PNAME</th>
				<th>Description</th>
				<th>Price</th>
				<th>Qty</th>
				<th>Link</th>
			</thead>
		</table>
	</div>
</div>
</div>
