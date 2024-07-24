import { customRender as render } from '../../utils/test-helper';
import MainPage from "./MainPage"
import { describe, expect, it } from 'vitest';

describe('Main Page', () => {
    it('Main Page should load properly - snapshot', async () => {
        const {container}  = render(<MainPage title={'Login'} children={<p> child component goes here </p>} />);
        expect(container).toMatchSnapshot();
    });
})