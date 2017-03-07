<script>
$(function(){
	
	$('#adminproduct').DataTable( {
		ajax: {
	        url: '/omashoppingfront/admin/products/all',
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
	                return '<a class="btn btn-primary" href="/omashoppingfront/show/'+row.id+'/product">View Item</a> &nbsp;<a class="btn btn-primary" href="/edit/'+row.id+'/product">Edit Item</a>&nbsp;<a class="btn btn-primary" href="/edit/'+row.id+'/">Delete Item</a> ';
	            }	
	        }
	        
	        
	    ]
	} );
	
	
	
});


</script>
<!--  

<div class="container">
	<div class="container col-md-offset-2 col-md-col-md-8">
		<form:form action="/onlineshopping/admin/add/category" method="POST"
			modelAttribute="category" class="form-horizontal">
			<form:hidden path="id" />

			<div class="form-group">
				<label class="col-md-2 control-label" for="name">Category
					Name</label>
				<div class="col-sm-6">
					<form:input type="text" path="name" id="name"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="name" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="imageUrl">Upload
					Image</label>
				<div class="col-sm-6">
					<form:input type="text" path="imageUrl" id="imageUrl"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="imageUrl" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="description">Description</label>
				<div class="col-sm-6">
					<form:input type="text" path="description" id="description"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="description" class="help-inline" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</div>

-->

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
