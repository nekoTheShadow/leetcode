import { minimumPairRemoval } from "./solution";

describe("minimumPairRemoval", () => {
  it("Example 1:", () => {
    const nums = [5, 2, 3, 1];
    const output = 2;
    expect(minimumPairRemoval(nums)).toBe(output);
  });

  it("Example 2:", () => {
    const nums = [1, 2, 2];
    const output = 0;
    expect(minimumPairRemoval(nums)).toBe(output);
  });
});
