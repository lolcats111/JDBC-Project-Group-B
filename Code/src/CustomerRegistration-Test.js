/**
 * Test case for Customer Registration screen.
 */

     describe('Customer Registration',()=>{

    	 let document;
    	 beforeAll(function () {
    		 document = getDOM();
    	 });

    	 it('Checking tthe attributes are defined', function() {
            expect(document.getElementById('registerCustomer')).toBeDefined();
            expect(document.getElementById('customerId')).toBeDefined();
            expect(document.getElementById('customerName')).toBeDefined();
            expect(document.getElementById('customerAge')).toBeDefined();
            expect(document.getElementById('customerSalary')).toBeDefined();
            expect(document.getElementById('city')).toBeDefined();
    	 });

    	 it('Checking tthe buttons are defined', function() {
            expect(document.getElementById('cancel')).toBeDefined();
            expect(document.getElementById('register')).toBeDefined();
    	 });

		it('Check there is header withe message "Customer Registration" in <h1>', function() {
			var str = document.getElementById('head').innerHTML;
			str=str.trim();
			str=str.toLowerCase();
            expect(str).toContain("customer registration</h1>");
        });

		it('Check the button background for Register as well as Cancel.', function() {
			var x = document.getElementById("cancel");
			var y = x.getAttribute("style");
			y=y.trim();
			y=y.toLowerCase();
			expect(y).toContain("#2345e4");
			
			x = document.getElementById("register");
			y = x.getAttribute("style");
			y=y.trim();
			y=y.toLowerCase();
			expect(y).toContain("#2345e4");
        });

		it('Check the button foreground for Register as well as Cancel.', function() {
			var x = document.getElementById("cancel");
			var y = x.getAttribute("style");
			y=y.trim();
			y=y.toLowerCase();
			expect(y).toContain("#ffffff");
			
			x = document.getElementById("register");
			y = x.getAttribute("style");
			y=y.trim();
			y=y.toLowerCase();
			expect(y).toContain("#ffffff");
        });

		it('Check there is alert window', function() {
			var str = document.getElementById('head').innerHTML;
			str=str.trim();
			str=str.toLowerCase();
			expect(str).toContain("alert");
            expect(str).toContain("customer registered successfully");
        });
      
    });
