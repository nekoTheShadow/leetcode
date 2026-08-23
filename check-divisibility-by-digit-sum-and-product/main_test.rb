# frozen_string_literal: true

require 'minitest/autorun'
require_relative './main'

describe '3622. Check Divisibility by Digit Sum and Product' do
  it 'Example 1' do
    _(check_divisibility 99).must_equal true
  end

  it 'Example 2' do
    _(check_divisibility 23).must_equal false
  end
end