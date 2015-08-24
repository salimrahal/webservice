'use strict';

describe('AffableBeanApp Controllers', function(){

  beforeEach(function(){
    this.addMatchers({
      toEqualData: function(expected) {
        return angular.equals(this.actual, expected);
      }
    });
  });
  
  beforeEach(module('affableBeanApp.services'));
  
  describe('DepartmentController', function(){
    var scope, ctrl, $httpBackend, cart;

    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller, Cart) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('http://localhost:8080/AffableBean/rest/department/2').
          respond([{id: 1, name : "milk", price: 2.3}, {id: 2, name : "juice", price: 5.1}]);

      scope = $rootScope.$new();
      ctrl = $controller(DepartmentController, {$scope: scope, $routeParams: {departmentId:2}});
      cart = Cart;
    }));


    it('should create "department" model with 2 products fetched from xhr', function() {
      expect(scope.products).toEqual([]);
      $httpBackend.flush();

      expect(scope.products).toEqualData(
          [{id: 1, name : "milk", price: 2.3}, {id: 2, name : "juice", price: 5.1}]);
    });


    it('should set category to 2', function() {
      expect(scope.category).toBe(2);
    });
    
    it('should have empty cart', function() {
      expect(cart.size()).toBe(0);
    });
    
    it('should have two items in the cart', function() {
      scope.addToCart({id: 3, name : "beer", price: 1.20});
      scope.addToCart({id: 4, name : "apple", price: 0.85});
      expect(cart.size()).toBe(2);
      expect(cart.getTotal()).toBe("2.05");
    });
  });

});
