import unittest

from solution import Router


class TestRouter(unittest.TestCase):

    def testScenario1(self):
        # Input:
        # ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
        # [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]
        #
        # Output:
        # [null, true, true, false, true, true, [2, 5, 90], true, 1]

        router = Router(3)

        self.assertTrue(router.addPacket(1, 4, 90))
        self.assertTrue(router.addPacket(2, 5, 90))
        self.assertFalse(router.addPacket(1, 4, 90))
        self.assertTrue(router.addPacket(3, 5, 95))
        self.assertTrue(router.addPacket(4, 5, 105))  # evicts (1,4,90)

        forwarded = router.forwardPacket()
        self.assertEqual([2, 5, 90], forwarded)

        self.assertTrue(router.addPacket(5, 2, 110))

        count = router.getCount(5, 100, 110)
        self.assertEqual(1, count)

    def testScenario2(self):
        # Input:
        # ["Router", "addPacket", "forwardPacket", "forwardPacket"]
        # [[2], [7, 4, 90], [], []]
        #
        # Output:
        # [null, true, [7, 4, 90], []]

        router = Router(2)

        self.assertTrue(router.addPacket(7, 4, 90))

        forwarded1 = router.forwardPacket()
        self.assertEqual([7, 4, 90], forwarded1)

        forwarded2 = router.forwardPacket()
        self.assertEqual([], forwarded2)
