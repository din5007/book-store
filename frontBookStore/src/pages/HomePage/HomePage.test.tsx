import { customRender as render } from '../../utils/test-helper';
import HomePage from "./HomePage"
import { describe, expect, it } from 'vitest';

describe('Home Page', () => {
    it('Home Page should load properly - snapshot', async () => {
        const {container}  = render(<HomePage />);
        expect(container).toMatchSnapshot();
    });
})