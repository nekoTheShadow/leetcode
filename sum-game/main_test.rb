# frozen_string_literal: true

require 'minitest/autorun'
require_relative './main'

describe '1927. Sum Game' do
  it 'Example 1' do
    _(sum_game('5023')).must_equal false
  end

  it 'Example 2' do
    _(sum_game('25??')).must_equal true
  end

  it 'Example 3' do
    _(sum_game('?3295???')).must_equal false
  end
end